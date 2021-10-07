package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.UsersSeedDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    public UserServiceImpl(ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper, UserRepository userRepository, PictureRepository pictureRepository) {
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {

        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder sb = new StringBuilder();

       Arrays.stream(gson.fromJson(readFromFileContent(), UsersSeedDto[].class))
                .filter(usersSeedDto -> {
                    boolean isValid = validationUtil.isValid(usersSeedDto)
                            && isEntityExist(usersSeedDto.getProfilePicture());

                    sb.append(isValid ?
                            String.format("Successfully imported user - %s",
                                    usersSeedDto.getUsername()) :
                            "Invalid user")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(usersSeedDto -> {

                    User user = modelMapper.map(usersSeedDto, User.class);
                    user.setProfilePicture(pictureRepository.findByPath(usersSeedDto.getProfilePicture()));

                return user;
                })
            .forEach(userRepository::save);

        return sb.toString();
    }

    private boolean isEntityExist(String path) {

        return pictureRepository.existsByPath(path);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        userRepository
                .findAllUsersAndTheirPostCount()
        .forEach(u -> {

            sb.append(String.format("User: %s", u.getUsername()))
                    .append(System.lineSeparator())
                    .append(String.format(("Post count: %d"), u.getPosts().size()))
                    .append(System.lineSeparator())
                    ;

                    u.getPosts()
                            .forEach(p -> {

                                sb.append("==Post Details: ")
                                        .append(System.lineSeparator())
                                        .append(String.format("----Caption: %s", p.getCaption())
                                        ).append(System.lineSeparator())
                                        .append(String.format("----Picture Size: %.2f", p.getPicture().getSize()))
                                        .append(System.lineSeparator());
                            });
        });

        return sb.toString();
    }
}
