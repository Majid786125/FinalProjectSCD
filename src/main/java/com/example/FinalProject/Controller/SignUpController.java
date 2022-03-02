package com.example.FinalProject.Controller;

import com.example.FinalProject.entity.*;
import com.example.FinalProject.repository.*;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class SignUpController {


    Country country;

    Religion religion;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    PaymentmethodRepository paymentmethodRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ReligionRepository religionRepository;

    @Autowired
    SignupRepository signupRepository;

    public void insertSingUpData(Signup signup) throws SQLException
    {
        signupRepository.save(signup);
    }
    public void updateSignUp(Signup signup) throws SQLException
    {
        signupRepository.save(signup);
    }
    public List<Signup> findAll()
    {
        return signupRepository.findAll();
    }
    public Optional<Signup> findbyId(long Id)
    {
        return signupRepository.findAllById(Id);
    }
    public Country findCountryId(String val)
    {
        List<Country> country=countryRepository.findAll();
        for(Country obj:country)
        {
            if(Objects.equals(obj.getCountryName(), val))
            {
                return obj;
            }
        }
        return null;
    }
    public Religion findReligionId(String val)
    {
        List<Religion> religions=religionRepository.findAll();
        for(Religion obj:religions)
        {
            if(Objects.equals(obj.getReligionName(), val))
            {
                return obj;
            }
        }
        return null;
    }

    public Signup findSignId(String val)
    {
        List<Signup> signupList=signupRepository.findAll();
        for(Signup obj:signupList)
        {
            if(Objects.equals(obj.getUserName(), val))
            {
                return obj;
            }
        }
        return null;
    }

    public Paymentmethod findPaymentId(String val)
    {
        List<Paymentmethod>  paymentmethodList=paymentmethodRepository.findAll();
        for(Paymentmethod obj:paymentmethodList)
        {
            if(Objects.equals(obj.getUserName(), val))
            {
                return obj;
            }
        }
        return null;
    }

    public Project findProjectId(String val)
    {
        List<Project>  projectList=projectRepository.findAll();
        for(Project obj:projectList)
        {
            if(Objects.equals(obj.getProjectName(), val))
            {
                return obj;
            }
        }
        return null;
    }

}