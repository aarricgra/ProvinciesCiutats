package com.example.provinciesciutats2.controller;

import com.example.provinciesciutats2.model.entintats.File;
import com.example.provinciesciutats2.model.repositoris.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileRepository fileRepository;
    @GetMapping("/")
    public List<File> getAll() {
        return fileRepository.findAll();
    }
    @PostMapping("/")
    public String upload(@RequestParam("file") MultipartFile uploadedFile) throws
            IOException {
        return fileRepository.save(new File(uploadedFile.getContentType(),
                uploadedFile.getBytes())).fileid.toString();
    }
    @PostMapping("/delete/{id}")
    public RedirectView deleteFile(@PathVariable UUID id) {
        try {
            fileRepository.deleteById(id);
            return new RedirectView("/files/web");
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found with id: "+ id);
        }
    }
    @GetMapping("/id/{id}")
    public File getFileById(@PathVariable UUID id) {
        return fileRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "File '%s' not found".formatted(id)));
    }
    @GetMapping("/{id}")
    public byte[] getFile(@PathVariable UUID id) {
        return fileRepository.findById(id).map(f -> f.data)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "File '%s' not found".formatted(id)));
    }
    /* web upload */
    @GetMapping("/web") public String webView() {
        return "<div style='text-align: center;'>" +
                "<h2 style='color: #0096f7;'>Puja el teu fitxer</h2>" +
                "<form method='POST' action='/files/web' enctype='multipart/form-data'"+
        " style='display:flex; flex-direction: column; align-items: center;'>" +
        "<label for='file' style='border: 2px dashed #0096f7; padding: 1em; cursor: "+
        "pointer; border-radius: 5px; background-color: #f4f4f4; box-shadow: 0 4px 6px rgba(0, 0, "+
                "0, 0.1);'>" +
        "<span id='file-label' style='display: block; text-align: center; font-size: "+
        "14px; color: #333;'>Selecciona un fitxer</span>" +
        "<input id='file' type='file' name='file' style='display: none;' "+
        "onchange='handleFileSelect()'>" +
        "</label>" +
                "<img id='preview' style='width: 12em; max-height: 12em; object-fit: contain; "+
        "border: 2px solid #0096f7; margin-top: 1em; border-radius: 5px; box-shadow: 0 4px 6px "+
        "rgba(0, 0, 0, 0.1);'>" +
        "<input type='submit' style='background: #0096f7; color: white; border: 0; "+
        "border-radius: 5px; padding: 8px; margin-top: 1em; cursor: pointer;'>" +
        "</form>" +
                "<div style='display:flex; flex-wrap: wrap; gap: 1em;'>" +
                fileRepository.findAll().stream()
                        .map(file -> "<div style='position:relative;'><img src='/files/" +
                                        file.fileid + "' style='width: 12em; height: 12em; object-fit: contain; border: 2px "+
                                "solid #0096f7; border-radius: 5px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);'>" +
        "<form method='POST' action='/files/delete/" + file.fileid + "' "+
        "style='position:absolute;top:0;right:0;'>" +
        "<input type='submit' value='Delete' "+
        "style='background:#ff0000;color: white;border: 0;border-radius: 3px;padding: "+
        "px;'></form></div>")
                .collect(Collectors.joining()) +
                "</div>" +
                "</div>" +
                "<script>" +
                "function handleFileSelect() {" +
                "var fileLabel = document.getElementById('file-label');" +
                "var previewImage = document.getElementById('preview');" +
                "var fileInput = document.getElementById('file');" +
                "fileLabel.textContent = 'Fitxer seleccionat: ' + fileInput.files[0].name;" +
                "previewImage.src = window.URL.createObjectURL(fileInput.files[0]);" +
                "}" +
                "</script>";
    }
    @PostMapping("/web") public String webUpload(@RequestParam("file") MultipartFile
                                                         uploadedFile) throws IOException { upload(uploadedFile); return webView(); }
}
