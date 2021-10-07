package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Seller;
import softuni.exam.models.dtos.SellerSeedDto;
import softuni.exam.models.dtos.SellerSeedRootDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SellerServiceImpl implements SellerService {

    public static final String SELLERS_INPUT_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    private final ValidationUtil validationUtil;
    private final SellerRepository sellerRepository;
    private final XMLParser xmlParser;
    private final ModelMapper modelMapper;

    public SellerServiceImpl(ValidationUtil validationUtil, SellerRepository sellerRepository, XMLParser xmlParser, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {

        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException, JAXBException {

        return  Files.readString(Path.of(SELLERS_INPUT_FILE_PATH));

    }

    @Override
    public String importSellers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        SellerSeedRootDto sellerSeedRootDto = xmlParser.fromFIle(SELLERS_INPUT_FILE_PATH,
                SellerSeedRootDto.class);

        sellerSeedRootDto
                .getSellers()
                .stream()
                .filter(sellerSeedDto -> {
                    boolean isValid = validationUtil.isValid(sellerSeedDto);

                    sb.append(isValid ? String.format("Successfully import seller %s - %s",
                            sellerSeedDto.getFirstName(),
                            sellerSeedDto.getEmail()) : "Invalid seller")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(sellerSeedDto -> {

                    SellerSeedDto seedDto = modelMapper.map(sellerSeedDto,
                            SellerSeedDto.class);

                    seedDto.setTown(sellerSeedDto.getTown());

                    return seedDto;

                }).map(sellerSeedDto -> modelMapper.map(sellerSeedDto, Seller.class))
                .forEach(sellerRepository::save);

        return sb.toString();
    }

    @Override
    public Seller getSellerById(Long id) {

        return sellerRepository
                .findById(id)
                .orElse(null);
    }
}
