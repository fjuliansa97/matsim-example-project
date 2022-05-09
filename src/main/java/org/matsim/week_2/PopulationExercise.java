package org.matsim.week_2;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.population.*;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.population.PopulationUtils;

public class PopulationExercise {

    public static void main(String[] args) {

        Config config = ConfigUtils.createConfig();
        Population emptyPopulation = PopulationUtils.createPopulation(config);
        PopulationFactory popFactory = emptyPopulation.getFactory();

        //loop goes here

        for (int j = 1; j <= 500; j++) {

            Person person1 = popFactory.createPerson(Id.createPersonId(j));

            emptyPopulation.addPerson(person1);

            Plan plan1 = popFactory.createPlan();
            person1.addPlan(plan1);

            Activity homeAct = popFactory.createActivityFromCoord("h", new Coord(0, 0));
            homeAct.setEndTime(7 * 60 * 60 + Math.random() * 3600);
            plan1.addActivity(homeAct);

            Leg leg2work = popFactory.createLeg(TransportMode.car);
            plan1.addLeg(leg2work);

            Activity workAct = popFactory.createActivityFromCoord("w", new Coord(990, 0));
            workAct.setEndTime(16 * 60 * 60 + Math.random() * 3600);
            plan1.addActivity(workAct);

            Leg leg2home = popFactory.createLeg(TransportMode.car);
            plan1.addLeg(leg2home);

            Activity endAct = popFactory.createActivityFromCoord("h", new Coord(0, 0));
            plan1.addActivity(endAct);
        }

        PopulationWriter writer = new PopulationWriter(emptyPopulation);
        writer.write("C:/Users/Lenovo/OneDrive - Universidad Nacional de Colombia/Master Deutschland/2022 - SS/MatSim/matsim-example-project/scenarios/week_2/miniPopulation.xml");

    }

}
