package com.example.provinciesciutats2.model.entintats;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID fileid;
    public String contenttype;
    @Column(length = 1000000000)
    public byte[] data;
    public File(){}
    public File(String contenttype, byte[] data) {
        this.contenttype = contenttype;
        this.data = data;
    }
}