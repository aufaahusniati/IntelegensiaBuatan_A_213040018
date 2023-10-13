package id.ac.unpas.ib;

import id.ac.unpas.ib.bfs.BreadthFirstSearch;
import id.ac.unpas.ib.dls.DepthLimitedSearch;
import id.ac.unpas.ib.ucs.NodeUCS;
import id.ac.unpas.ib.ucs.UniformCostSearch;

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

        Peta.addTetangga(rayaKopo);

        rayaKopo.addTetangga(Peta);
        rayaKopo.addTetangga(astanaAnyar);

        astanaAnyar.addTetangga(rayaKopo);
        astanaAnyar.addTetangga(kebonJati);
        astanaAnyar.addTetangga(veteran);

        kebonJati.addTetangga(astanaAnyar);
        kebonJati.addTetangga(suniaraja);

        suniaraja.addTetangga(kebonJati);
        suniaraja.addTetangga(aceh);

        aceh.addTetangga(suniaraja);
        aceh.addTetangga(banda);

        banda.addTetangga(aceh);
        banda.addTetangga(gedungSate);
        banda.addTetangga(sumbawa);

        veteran.addTetangga(astanaAnyar);
        veteran.addTetangga(sunda);

        sunda.addTetangga(veteran);
        sunda.addTetangga(sumbawa);

        sumbawa.addTetangga(sunda);
        sumbawa.addTetangga(banda);

        gedungSate.addTetangga(banda);

        // Mencetak pesan yang menunjukan bahwa pencarian menggunakan algoritma BFS akan dimulai
        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(Peta, gedungSate);
        System.out.println();

        // Mencetak pesan yang menunjukan bahwa pencarian menggunakan algoritma DLS akan dimulai
        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        // Mengatur batasan kedalaman pencarian dengan nilai 10
        dls.setLimit(10);
        dls.search(Peta, gedungSate);
        System.out.println();

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

        // Mencetak pesan yang menunjukan bahwa pencarian menggunakan algoritma UCS akan dimulai
        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(PetaUCS, gedungSateUCS);
        System.out.println();
    }
}
