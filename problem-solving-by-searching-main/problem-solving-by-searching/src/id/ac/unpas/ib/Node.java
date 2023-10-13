package id.ac.unpas.ib;

import java.util.ArrayList;
import java.util.List;

public class Node {
    // Deklarasi variable instance
    private String nilai;
    // Deklarasi variable instance yang digunakan untuk menyimpan daftar suksesor
    private List<Node> tetangga;

    public Node(String nilai) {
        tetangga = new ArrayList<>();
        this.nilai = nilai;
    }

    // Metode yang digunakan untuk mengatur nilai dari node
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    // Metode yang digunakan untuk mendapatkan nilai dari node
    public String getNilai() {
        return nilai;
    }

    // Metode yang digunakan untuk mengatur daftar tetangga (successor) dari node
    public void setTetangga(List<Node> tetangga) {
        this.tetangga = tetangga;
    }

    // Metode yang digunakan untuk mendapatkan daftar tetannga (successor) dari node
    public List<Node> getTetangga() {
        return tetangga;
    }

    // Metode yang digunakan untuk menambahkan node sebagai tetangga (successor) dari node
    public void addTetangga(Node node) {
        tetangga.add(node);
    }

    // Metode override membandingkan dua objek 'node' berdasarkan nilai (nilai atribut)
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return ((Node) obj).nilai.equals(this.nilai);
        }
        return false;
    }
}
