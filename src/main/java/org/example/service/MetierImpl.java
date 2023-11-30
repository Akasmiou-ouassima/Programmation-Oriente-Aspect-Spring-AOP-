package org.example.service;

import org.example.aspects.Log;
import org.example.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles={"USER","ADMIN"}) // both USER and ADMIN can access this method
    public void process() {
        System.out.println("Business Process ...");

    }

    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN"}) // only ADMIN can access this method
    public double compute() {
        double x = 78;
        System.out.println("Business Computing and returning ...");
        return x;
    }
}
