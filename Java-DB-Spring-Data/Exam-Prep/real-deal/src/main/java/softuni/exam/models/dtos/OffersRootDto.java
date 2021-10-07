package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OffersRootDto {

    @XmlElement(name = "offer")
    private List<OffersSeedDto> offers;

    public OffersRootDto() {
    }

    public OffersRootDto(List<OffersSeedDto> offers) {
        this.offers = offers;
    }

    public List<OffersSeedDto> getOffers() {
        return offers;
    }

    public void setOffers(List<OffersSeedDto> offers) {
        this.offers = offers;
    }
}
