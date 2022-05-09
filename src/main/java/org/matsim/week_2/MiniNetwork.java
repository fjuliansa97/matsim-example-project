package org.matsim.week_2;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.*;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.utils.geometry.CoordUtils;

public class MiniNetwork {


    public static void main(String[] args) {
        Network emptyNetwork = NetworkUtils.createNetwork();

        NetworkFactory networkFactory = emptyNetwork.getFactory();

        Coord a = CoordUtils.createCoord(0,0);
        Coord b = CoordUtils.createCoord(0,1000);
        Coord c = CoordUtils.createCoord(2000,500);
        Coord d = CoordUtils.createCoord(2000,-500);
        Coord e = CoordUtils.createCoord(3000,0);
        Coord f = CoordUtils.createCoord(4000,0);

        Node nodeA = networkFactory.createNode(Id.createNodeId("nodeA"), a);
        Node nodeB = networkFactory.createNode(Id.createNodeId("nodeB"), b);
        Node nodeC = networkFactory.createNode(Id.createNodeId("nodeC"), c);
        Node nodeD = networkFactory.createNode(Id.createNodeId("nodeD"), d);
        Node nodeE = networkFactory.createNode(Id.createNodeId("nodeE"), e);
        Node nodeF = networkFactory.createNode(Id.createNodeId("nodeF"), f);


        emptyNetwork.addNode(nodeA);
        emptyNetwork.addNode(nodeB);
        emptyNetwork.addNode(nodeC);
        emptyNetwork.addNode(nodeD);
        emptyNetwork.addNode(nodeE);
        emptyNetwork.addNode(nodeF);

        Link link1 = networkFactory.createLink(Id.createLinkId("link1"), nodeA, nodeB);
        Link link2 = networkFactory.createLink(Id.createLinkId("link2"), nodeB, nodeA);
        Link link3 = networkFactory.createLink(Id.createLinkId("link3"), nodeB, nodeC);
        Link link4 = networkFactory.createLink(Id.createLinkId("link4"), nodeC, nodeB);
        Link link5 = networkFactory.createLink(Id.createLinkId("link5"), nodeB, nodeD);
        Link link6 = networkFactory.createLink(Id.createLinkId("link6"), nodeD, nodeB);
        Link link7 = networkFactory.createLink(Id.createLinkId("link7"), nodeD, nodeE);
        Link link8 = networkFactory.createLink(Id.createLinkId("link8"), nodeE, nodeD);
        Link link9 = networkFactory.createLink(Id.createLinkId("link9"), nodeC, nodeE);
        Link link10 = networkFactory.createLink(Id.createLinkId("link10"), nodeE, nodeC);
        Link link11 = networkFactory.createLink(Id.createLinkId("link11"), nodeE, nodeF);
        Link link12 = networkFactory.createLink(Id.createLinkId("link12"), nodeF, nodeE);

        emptyNetwork.addLink(link1);
        emptyNetwork.addLink(link2);
        emptyNetwork.addLink(link3);
        emptyNetwork.addLink(link4);
        emptyNetwork.addLink(link5);
        emptyNetwork.addLink(link6);
        emptyNetwork.addLink(link7);
        emptyNetwork.addLink(link8);
        emptyNetwork.addLink(link9);
        emptyNetwork.addLink(link10);
        emptyNetwork.addLink(link11);
        emptyNetwork.addLink(link12);

        // Suburban Roads
        strsTyp(link1, 1);
        strsTyp(link2, 1);
        strsTyp(link11, 1);
        strsTyp(link12, 1);

        //Urban Roads
        strsTyp(link3, 0);
        strsTyp(link4, 0);
        strsTyp(link5, 0);
        strsTyp(link6, 0);
        strsTyp(link7, 0);
        strsTyp(link8, 0);
        strsTyp(link9, 0);
        strsTyp(link10, 0);


        NetworkWriter writer = new NetworkWriter(emptyNetwork);
        writer.write("C:/Users/Lenovo/OneDrive - Universidad Nacional de Colombia/Master Deutschland/2022 - SS/MatSim/matsim-example-project/scenarios/week_2/miniNetwork");
    }

    public static void strsTyp(Link link, int i) {
        if( i == 1){ //Suburban Roads
            link.setCapacity(500);
            link.setFreespeed(22.22);
            link.setNumberOfLanes(2);
        } else { //Urban Roads
            link.setCapacity(250);
            link.setFreespeed(13.88);
            link.setNumberOfLanes(1);
        }
    }
}
