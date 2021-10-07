package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.dtos.PostsSeedRootDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    public static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;
    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, XMLParser xmlParser, PostRepository postRepository, PictureRepository pictureRepository, UserRepository userRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean areImported() {

        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        PostsSeedRootDto postsSeedRootDto = xmlParser.fromFIle(POSTS_FILE_PATH, PostsSeedRootDto.class);

       postsSeedRootDto
                .getPosts().stream()
                .filter(postSeedDto -> {
                    boolean isValid = validationUtil.isValid(postSeedDto) &&
                            isPictureExist(postSeedDto.getPicture().getPath())
                            && pictureRepository.existsByPath(postSeedDto.getPicture().getPath())
                            && isUserExist(postSeedDto.getUser().getUsername())
                            && userRepository.existsByUsername(postSeedDto.getUser().getUsername());

                    sb.append(isValid
                            ?
                            String.format("Successfully imported Post, made by %s",
                                    postSeedDto.getUser().getUsername())
                            : "Invalid post"
                    ).append(System.lineSeparator());

                    return isValid;
                })
         .map(postSeedDto -> {

                    Post post = modelMapper
                            .map(postSeedDto, Post.class);
                    post.setUser(userRepository.findByUsername(postSeedDto.getUser().getUsername()));
                    post.setPicture(pictureRepository.findByPath(postSeedDto.getPicture().getPath()));

                    return post;
                })
                .forEach(postRepository::save);


        return sb.toString();
    }

    private boolean isPictureExist(String path) {

    return pictureRepository.existsByPath(path);
    }

    private boolean isUserExist(String username) {

        return userRepository.existsByUsername(username);
    }
}
