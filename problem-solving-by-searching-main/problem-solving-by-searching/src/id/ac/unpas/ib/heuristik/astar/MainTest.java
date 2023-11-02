package id.ac.unpas.ib.heuristik.astar;

// Mendeklarasikan sebuah kelas dengan nama MainTest
public class MainTest {
    // Membuat object node yang mewakili jalan-jalan di dalam peta.
    // Setiap jalan memiliki nama dan memiliki tetangga atau jalan yang terhubung

    public static void main(String[] args) {
        Node Peta = new Node("Jl. Peta");
        Node veteran = new Node("Jl. Veteran");
        Node sunda = new Node("Jl. Sunda");
        Node sumbawa = new Node("Jl. Sumbawa");
        Node banda= new Node("Jl. Banda");
        Node gedungSate = new Node("Gedung Sate");
        Node rayaKopo = new Node("Jl. Raya Kopo");
        Node astanaAnyar = new Node("Jl. Astana Anyar");
        Node kebonJati = new Node("Jl. Kebon Jati");
        Node suniaraja = new Node("Jl. Suniaraja");
        Node aceh = new Node("Jl. Aceh");

        // Membuat object NODEUCS yang mewakili jalan-jalan dengan cost terkait
        NodeUCS PetaUCS = new NodeUCS(Peta, 29);
        NodeUCS rayaKopoUCS = new NodeUCS(rayaKopo, 28);
        NodeUCS astanaAnyarUCS = new NodeUCS(astanaAnyar, 26);
        NodeUCS kebonJatiUCS = new NodeUCS(kebonJati, 23);
        NodeUCS suniarajaUCS = new NodeUCS(suniaraja, 18);
        NodeUCS acehUCS = new NodeUCS(aceh, 12);
        NodeUCS bandaUCS = new NodeUCS(banda, 4);
        NodeUCS gedungSateUCS = new NodeUCS(gedungSate, 0);
        NodeUCS veteranUCS = new NodeUCS(veteran, 26);
        NodeUCS sundaUCS = new NodeUCS(sunda, 21);
        NodeUCS sumbawaUCS = new NodeUCS(sumbawa, 15);

        PetaUCS.addTetangga(rayaKopoUCS, 1);

        rayaKopoUCS.addTetangga(PetaUCS, 1);
        rayaKopoUCS.addTetangga(astanaAnyarUCS, 2);

        astanaAnyarUCS.addTetangga(rayaKopoUCS, 2);
        astanaAnyarUCS.addTetangga(kebonJatiUCS, 3);
        astanaAnyarUCS.addTetangga(veteranUCS, 4);

        kebonJatiUCS.addTetangga(astanaAnyarUCS, 3);
        kebonJatiUCS.addTetangga(suniarajaUCS, 4);

        suniarajaUCS.addTetangga(kebonJatiUCS, 4);
        suniarajaUCS.addTetangga(acehUCS, 5);

        acehUCS.addTetangga(suniarajaUCS, 5);
        acehUCS.addTetangga(bandaUCS, 6);

        bandaUCS.addTetangga(acehUCS, 6);
        bandaUCS.addTetangga(gedungSateUCS, 8);
        bandaUCS.addTetangga(sumbawaUCS, 7);

        veteranUCS.addTetangga(astanaAnyarUCS, 4);
        veteranUCS.addTetangga(sundaUCS, 5);

        sundaUCS.addTetangga(veteranUCS, 5);
        sundaUCS.addTetangga(sumbawaUCS, 6);

        sumbawaUCS.addTetangga(sundaUCS, 6);
        sumbawaUCS.addTetangga(bandaUCS, 7);

        gedungSateUCS.addTetangga(bandaUCS, 8);

        // menampilkan hasil dari algoritma A*
        System.out.println("A*");
        // inisialisasi objek AStar
        AStar aStar = new AStar();
        // memanggil fungsi search dari objek aStar dari node aradUCS ke bucharestUCS
        aStar.search(PetaUCS, gedungSateUCS);
        System.out.println();
    }
}
