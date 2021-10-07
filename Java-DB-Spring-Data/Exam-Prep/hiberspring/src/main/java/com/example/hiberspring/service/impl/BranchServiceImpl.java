package com.example.hiberspring.service.impl;

import com.example.hiberspring.domain.dtos.BranchesNameAndTownDto;
import com.example.hiberspring.domain.entities.Branch;
import com.example.hiberspring.repository.BranchRepository;
import com.example.hiberspring.repository.TownRepository;
import com.example.hiberspring.service.BranchService;
import com.example.hiberspring.util.FileUtil;
import com.example.hiberspring.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.hiberspring.common.Constants.INCORRECT_DATA_MESSAGE;

@Service
public class BranchServiceImpl implements BranchService {

    private final Gson gson;
    private final BranchRepository branchRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final TownRepository townRepository;

    public BranchServiceImpl(Gson gson, BranchRepository branchRepository, ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, TownRepository townRepository) {
        this.gson = gson;
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.townRepository = townRepository;

    }

    @Override
    public Boolean branchesAreImported() {

        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return fileUtil.readFile("src/main/resources/files/branches.json");
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {


        StringBuilder sb = new StringBuilder();

        List<Branch> collect = Arrays.stream(gson.fromJson(readBranchesJsonFile(), BranchesNameAndTownDto[].class))
                .filter(branchesNameAndTownDto -> {
                    boolean isValid = validationUtil.isValid(branchesNameAndTownDto);

                    sb.append(isValid ? String.format("Successfully imported Branch - %s",
                            branchesNameAndTownDto.getName())
                            : INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());

                    return isValid;
                }).map(branchDto -> {
                    Branch branch = modelMapper.map(branchDto, Branch.class);

                    branch.setTown(this.townRepository.getByName(branchDto.getTown()));
                    return branch;
                }).collect(Collectors.toList());
//        .forEach(branchRepository::save);

        return sb.toString();
    }

    private boolean isTownExist(String town) {
    return townRepository.existsByName(town);
    }

}
