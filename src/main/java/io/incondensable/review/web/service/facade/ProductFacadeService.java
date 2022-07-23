package io.incondensable.review.web.service.facade;

import io.incondensable.review.web.dto.ProductInformationDto;

public interface ProductFacadeService {

    ProductInformationDto getReviewableProductInformation(Long productId);

}
