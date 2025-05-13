package org.example.liongroup.service;

import org.example.liongroup.repo.HomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    HomeRepo homeRepo;


}
