package ro.ubb.flowershop.web.converter;

import ro.ubb.flowershop.core.model.BaseEntity;
import ro.ubb.flowershop.web.dto.BaseDto;

public interface Converter<Model extends BaseEntity<Integer>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}
