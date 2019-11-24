package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TrenerMiastoString {
    String nazwiskoTrenera;

    String nazwaMiasta;

    MultipartFile logo;
}
