package com.example.proyecto_demo_olguin.config;

import com.example.proyecto_demo_olguin.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    public void newRevision(Object revisionEntity){ final Revision revision = (Revision) revisionEntity;}

}
