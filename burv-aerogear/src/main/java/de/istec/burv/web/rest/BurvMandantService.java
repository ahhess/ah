package de.istec.burv.web.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.istec.burv.web.controller.BurvMandantController;
import de.istec.burv.web.data.BurvMandantRepository;
import de.istec.burv.web.model.BurvMandant;

@Path("/burvmandants")
@RequestScoped
@Stateful
public class BurvMandantService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private BurvMandantRepository repository;

    @Inject
    BurvMandantController controller;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BurvMandant> listAllBurvMandants() {
        return repository.findAllOrderedByBezeichnung();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BurvMandant lookupBurvMandantById(@PathParam("id") String id) {
        BurvMandant member = repository.findById(id);
        if (member == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return member;
    }

    /**
     * Creates a new member from the values provided.  Performs validation, and will return a JAX-RS response with either
     * 200 ok, or with a map of fields, and related errors.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBurvMandant(BurvMandant member) {

        Response.ResponseBuilder builder = null;

        try {
            //Validates member using bean validation
            validateBurvMandant(member);

            controller.save(member);

            //Create an "ok" response
            builder = Response.ok();
        } catch (ConstraintViolationException ce) {
            //Handle bean validation issues
            builder = createViolationResponse(ce.getConstraintViolations());
        } catch (ValidationException e) {
            //Handle the unique constrain violation
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("bezeichnung", "Bezeichnung");
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }


    /**
     * <p>Validates the given BurvMandant variable and throws validation exceptions based on the type of error.
     * If the error is standard bean validation errors then it will throw a ConstraintValidationException
     * with the set of the constraints violated.</p>
     * <p>If the error is caused because an existing member with the same bezeichnung is registered it throws a regular
     * validation exception so that it can be interpreted separately.</p>
     *
     * @param member BurvMandant to be validated
     * @throws ConstraintViolationException If Bean Validation errors exist
     * @throws ValidationException          If member with the same bezeichnung already exists
     */
    private void validateBurvMandant(BurvMandant member) throws ConstraintViolationException, ValidationException {
        //Create a bean validator and check for issues.
        Set<ConstraintViolation<BurvMandant>> violations = validator.validate(member);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }

        //Check the uniqueness of the bezeichnung
        if (bezeichnungAlreadyExists(member.getBezeichnung())) {
            throw new ValidationException("Unique Bezeichnung Violation");
        }
    }

    /**
     * Creates a JAX-RS "Bad Request" response including a map of all violation fields, and their message.
     * This can then be used by clients to show violations.
     *
     * @param violations A set of violations that needs to be reported
     * @return JAX-RS response containing all violations
     */
    private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
        log.fine("Validation completed. violations found: " + violations.size());

        Map<String, String> responseObj = new HashMap<String, String>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
    }

    /**
     * Checks if a member with the same bezeichnung is already registered.  This is the only way to
     * easily capture the "@UniqueConstraint(columnNames = "bezeichnung")" constraint from the BurvMandant class.
     *
     * @param bezeichnung to check
     * @return True if the bezeichnung already exists, and false otherwise
     */
    public boolean bezeichnungAlreadyExists(String bezeichnung) {
        BurvMandant member = null;
        try {
            member = repository.findByBezeichnung(bezeichnung);
        } catch (NoResultException e) {
            // ignore
        }
        return member != null;
    }
}
