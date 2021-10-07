package com.example.xmlproductstore.services;

import com.example.xmlproductstore.dtos.*;
import com.example.xmlproductstore.entities.User;
import com.example.xmlproductstore.repositories.UserRepository;
import com.example.xmlproductstore.utils.ValidatorUtilImpl;
import com.example.xmlproductstore.utils.XMLFormatConverter;
import com.example.xmlproductstore.utils.XMLParser;
import com.example.xmlproductstore.utils.XMLParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.xmlproductstore.constants.IOFilePaths.USERS_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtilImpl validatorUtil;
    private final XMLParser parser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtilImpl validatorUtil, XMLParser parser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.parser = parser;
    }

    @Override
    public void seedUsers() throws JAXBException, FileNotFoundException {

        if (userRepository.count() > 0){
            return;
        }

        UsersSeedRootDto usersSeedRootDto = parser.fromFIle(USERS_FILE_PATH, UsersSeedRootDto.class);

        usersSeedRootDto
                .getUsers()
                .stream()
                .filter(validatorUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public User getRandomSeller() {

        long count = this.userRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, count + 1);
        return this.userRepository.getById(randomId);
    }

    @Override
    public User getRandomBuyer() {

        long count = this.userRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, count + 1);
        return this.userRepository.getById(randomId);
    }

    @Override
    public UsersSoldPRoductsRootDto getAllUsersSuccsessfullySoldProduct() {
        UsersSoldPRoductsRootDto usersSoldPRoductsRootDto = new UsersSoldPRoductsRootDto();

        usersSoldPRoductsRootDto
                .setUsers(userRepository
                        .getAllBySoldProductsIsNotNullAndBuyerIsNotNull()
                .stream()
                  .filter(validatorUtil::isValid)
                 .map(user ->
                         modelMapper.map(user,
                                 UserFirstAndLastNameDto.class))
                .collect(Collectors.toSet()));

        return usersSoldPRoductsRootDto;
    }

    @Override
    public UsersProductsRootDto getAllUsersWithProducts() {

        UsersProductsRootDto usersProductsRootDto = new UsersProductsRootDto();

        usersProductsRootDto.setUsers(
                userRepository.findAllUsersWithSoldProductsOrderedByNumberOfProductsDescAndLastName()
                .stream()
                .filter(validatorUtil::isValid)
                .map(user -> {
                    UserSoldProductsDto userSoldProductsDto =
                            modelMapper.map(user, UserSoldProductsDto.class);

                    //TODO does not map sold products correctly

                    return userSoldProductsDto;
                }).collect(Collectors.toList()));
        System.out.println();
        return usersProductsRootDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserServiceImpl that = (UserServiceImpl) o;
        return Objects.equals(userRepository, that.userRepository) && Objects.equals(modelMapper, that.modelMapper) && Objects.equals(validatorUtil, that.validatorUtil) && Objects.equals(parser, that.parser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRepository, modelMapper, validatorUtil, parser);
    }
}
