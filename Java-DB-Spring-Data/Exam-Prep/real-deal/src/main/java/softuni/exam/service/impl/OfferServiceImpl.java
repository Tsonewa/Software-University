package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Offer;
import softuni.exam.models.dtos.OffersRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.PictureService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OfferServiceImpl implements OfferService {

    public static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;
    private final ValidationUtil validationUtil;
    private final OfferRepository offerRepository;
    private final CarService carService;
    private final SellerService sellerService;
    private final PictureService pictureService;

    public OfferServiceImpl(ModelMapper modelMapper, XMLParser xmlParser, ValidationUtil validationUtil, OfferRepository offerRepository, CarService carService, SellerService sellerService, PictureService pictureService) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.offerRepository = offerRepository;
        this.carService = carService;
        this.sellerService = sellerService;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {

        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {

        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        OffersRootDto offersRootDto = xmlParser.fromFIle
                (OFFERS_FILE_PATH, OffersRootDto.class);

       offersRootDto
                .getOffers()
                .stream()
                .filter(offersSeedDto -> {
                    boolean isValid = validationUtil.isValid(offersSeedDto);

                    sb.append(isValid ? String.format("Successfully import offer %s - %b",
                            offersSeedDto.getAddedOn().toString(),
                            offersSeedDto.isHasGoldStatus()) : "Invalid offer")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(offersSeedDto -> {
                    Offer offer = modelMapper.map(offersSeedDto, Offer.class);

                    offer.setCar(carService.getCarById(offersSeedDto.getCar().getId()));
                    offer.setSeller(sellerService.getSellerById(offersSeedDto.getSeller().getId()));

                    offer.setAddedOn(LocalDateTime.parse(offer
                            .getAddedOn()
                            .format(DateTimeFormatter
                                    .ofPattern("yyyy-MM-dd'T'HH:mm:ss"))));

                    offer.setPictures(pictureService.getPicturesById(offer.getId()));

                    return offersSeedDto;
                })
               .map(o -> modelMapper.map(o, Offer.class))
                .forEach(offerRepository::save);

        return sb.toString();
    }
}
