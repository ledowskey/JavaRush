package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by DELL on 14.08.2017.
 */

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes image) {
        if (image == ImageTypes.BMP) return new BmpReader();
        else if (image == ImageTypes.JPG) return new JpgReader();
        else if (image == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
