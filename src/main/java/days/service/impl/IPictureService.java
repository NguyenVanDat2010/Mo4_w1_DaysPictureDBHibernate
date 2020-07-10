package days.service.impl;

import days.model.Picture;
import days.service.IGeneralService;

import java.util.List;

public interface IPictureService extends IGeneralService<Picture> {
    Picture update (Picture picture);

    void updateLike(Long id);
}
