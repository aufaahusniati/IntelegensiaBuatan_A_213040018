package id.ac.unpas.ib.heuristik.greedybfs;

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

        PetaUCS.addTetangga(rayaKopoUCS);

        rayaKopoUCS.addTetangga(PetaUCS);
        rayaKopoUCS.addTetangga(astanaAnyarUCS);

        astanaAnyarUCS.addTetangga(rayaKopoUCS);
        astanaAnyarUCS.addTetangga(kebonJatiUCS);
        astanaAnyarUCS.addTetangga(veteranUCS);

        kebonJatiUCS.addTetangga(astanaAnyarUCS);
        kebonJatiUCS.addTetangga(suniarajaUCS);

        suniarajaUCS.addTetangga(kebonJatiUCS);
        suniarajaUCS.addTetangga(acehUCS);

        acehUCS.addTetangga(suniarajaUCS);
        acehUCS.addTetangga(bandaUCS);

        bandaUCS.addTetangga(acehUCS);
        bandaUCS.addTetangga(gedungSateUCS);
        bandaUCS.addTetangga(sumbawaUCS);

        veteranUCS.addTetangga(astanaAnyarUCS);
        veteranUCS.addTetangga(sundaUCS);

        sundaUCS.addTetangga(veteranUCS);
        sundaUCS.addTetangga(sumbawaUCS);

        sumbawaUCS.addTetangga(sundaUCS);
        sumbawaUCS.addTetangga(bandaUCS);

        gedungSateUCS.addTetangga(bandaUCS);

         // menampilkan hasil dari algoritma Greedy Best First Search
         System.out.println("Greedy BFS");
         // inisialisasi objek GreedyBestFirstSearch
         GreedyBestFirstSearch bfs = new GreedyBestFirstSearch();
         // memanggil fungsi search dari objek GreedyBestFirstSearch dari node aradUCS ke
         // bucharestUCS
         bfs.search(PetaUCS, gedungSateUCS);
         System.out.println();
    }
}
