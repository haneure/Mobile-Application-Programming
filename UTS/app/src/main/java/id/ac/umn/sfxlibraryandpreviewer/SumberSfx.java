package id.ac.umn.sfxlibraryandpreviewer;

import java.io.Serializable;

public class SumberSfx implements Serializable {
    private String judul;
    private String keterangan;
    private String sfxURI;
    public SumberSfx(String judul, String keterangan, String sfxURI) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.sfxURI = sfxURI;
    }

    public String getJudul () {
        return this.judul;
    }
    public String getKeterangan() {
        return this.keterangan;
    }
    public String getSfxURI() {
        return this.sfxURI;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public void setSfxURI(String sfxURI) {
        this.sfxURI = sfxURI;
    }

    public String toString() {
        return this.getJudul() + " => " + this.getKeterangan();
    }

}
