/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.istec.burv.web.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.istec.burv.web.model.BurvMandant;

@ApplicationScoped
public class BurvMandantRepository {

    @Inject
    private EntityManager em;

    public BurvMandant findById(String id) {
        return em.find(BurvMandant.class, id);
    }

    public BurvMandant findByBezeichnung(String bezeichnung) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BurvMandant> criteria = cb.createQuery(BurvMandant.class);
        Root<BurvMandant> root = criteria.from(BurvMandant.class);
        criteria.select(root).where(cb.equal(root.get("bezeichnung"), bezeichnung));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<BurvMandant> findAllOrderedByBezeichnung() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BurvMandant> criteria = cb.createQuery(BurvMandant.class);
        Root<BurvMandant> root = criteria.from(BurvMandant.class);
        criteria.select(root).orderBy(cb.asc(root.get("bezeichnung")));
        return em.createQuery(criteria).getResultList();
    }

}
