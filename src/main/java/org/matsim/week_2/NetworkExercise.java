package org.matsim.week_2;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.*;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.utils.geometry.CoordUtils;

public class NetworkExercise {

    public static void main(String[] args) {
        Network emptyNetwork = NetworkUtils.createNetwork();

        NetworkFactory networkFactory = emptyNetwork.getFactory();

        Coord a = CoordUtils.createCoord(0,0);
        Coord b = CoordUtils.createCoord(0,1000);

        Node nodeA = networkFactory.createNode(Id.createNodeId("nodeA"), a);
        Node nodeB = networkFactory.createNode(Id.createNodeId("nodeB"), b);

        emptyNetwork.addNode(nodeA);
        emptyNetwork.addNode(nodeB);

        Link link1 = networkFactory.createLink(Id.createLinkId("link1"), nodeA, nodeB);
        Link link2 = networkFactory.createLink(Id.createLinkId("link2"), nodeB, nodeA);

        emptyNetwork.addLink(link1);
        emptyNetwork.addLink(link2);

        link1.setFreespeed(13.8);
        link1.setCapacity(1800);
        link1.setLength(1000);
        link1.setNumberOfLanes(2);

        link2.setFreespeed(13.8);
        link2.setCapacity(1800);
        link2.setLength(1000);
        link2.setNumberOfLanes(2);

        NetworkWriter writer = new NetworkWriter(emptyNetwork);
        writer.write("C:/Users/Lenovo/OneDrive - Universidad Nacional de Colombia/Master Deutschland/2022 - SS/MatSim/matsim-example-project/scenarios/week_2/testNetwork");
    }

}
