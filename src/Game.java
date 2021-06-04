import GeneticAlgorithmLibrary.GeneticAlgorithm;
import NeuralNetworkLibrary.NeuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Game {
    public static double THRESHOLD = 0.5;
    public static int NBR_CAR = 50;
    public static int NBR_GENERATION = 500;
    public static int TIME_RACE = 1000;

    private static void populate(ArrayList<Point> _exterior, ArrayList<Point> _interior, ArrayList<ArrayList<Point>> _checkpoints){
        _exterior.add(new Point(231, 67));
        _exterior.add(new Point(370, 57));
        _exterior.add(new Point(502, 59));
        _exterior.add(new Point(602, 81));
        _exterior.add(new Point(625, 99));
        _exterior.add(new Point(635, 132));
        _exterior.add(new Point(635, 165));
        _exterior.add(new Point(622, 214));
        _exterior.add(new Point(619, 243));
        _exterior.add(new Point(629, 274));
        _exterior.add(new Point(647, 305));
        _exterior.add(new Point(654, 343));
        _exterior.add(new Point(652, 363));
        _exterior.add(new Point(647, 382));
        _exterior.add(new Point(637, 402));
        _exterior.add(new Point(620, 426));
        _exterior.add(new Point(605, 452));
        _exterior.add(new Point(592, 473));
        _exterior.add(new Point(567, 485));
        _exterior.add(new Point(544, 490));
        _exterior.add(new Point(517, 490));
        _exterior.add(new Point(494, 486));
        _exterior.add(new Point(467, 478));
        _exterior.add(new Point(461, 471));
        _exterior.add(new Point(442, 465));
        _exterior.add(new Point(422, 463));
        _exterior.add(new Point(399, 473));
        _exterior.add(new Point(385, 487));
        _exterior.add(new Point(365, 508));
        _exterior.add(new Point(347, 528));
        _exterior.add(new Point(310, 548));
        _exterior.add(new Point(284, 552));
        _exterior.add(new Point(256, 554));
        _exterior.add(new Point(229, 548));
        _exterior.add(new Point(214, 534));
        _exterior.add(new Point(202, 514));
        _exterior.add(new Point(182, 502));
        _exterior.add(new Point(174, 490));
        _exterior.add(new Point(161, 462));
        _exterior.add(new Point(154, 442));
        _exterior.add(new Point(152, 415));
        _exterior.add(new Point(151, 383));
        _exterior.add(new Point(150, 352));
        _exterior.add(new Point(142, 337));
        _exterior.add(new Point(133, 318));
        _exterior.add(new Point(119, 302));
        _exterior.add(new Point(101, 282));
        _exterior.add(new Point(92, 258));
        _exterior.add(new Point(91, 233));
        _exterior.add(new Point(96, 210));
        _exterior.add(new Point(104, 182));
        _exterior.add(new Point(114, 161));
        _exterior.add(new Point(125, 135));
        _exterior.add(new Point(137, 110));
        _exterior.add(new Point(158, 91));
        _exterior.add(new Point(178, 79));
        _exterior.add(new Point(205, 72));
        _exterior.add(new Point(230, 68));
        _interior.add(new Point(303, 100));
        _interior.add(new Point(345, 98));
        _interior.add(new Point(392, 96));
        _interior.add(new Point(442, 96));
        _interior.add(new Point(479, 100));
        _interior.add(new Point(514, 106));
        _interior.add(new Point(550, 118));
        _interior.add(new Point(567, 130));
        _interior.add(new Point(571, 142));
        _interior.add(new Point(574, 158));
        _interior.add(new Point(570, 173));
        _interior.add(new Point(567, 198));
        _interior.add(new Point(564, 216));
        _interior.add(new Point(565, 230));
        _interior.add(new Point(570, 256));
        _interior.add(new Point(576, 278));
        _interior.add(new Point(581, 286));
        _interior.add(new Point(587, 304));
        _interior.add(new Point(593, 329));
        _interior.add(new Point(598, 346));
        _interior.add(new Point(598, 362));
        _interior.add(new Point(594, 373));
        _interior.add(new Point(582, 390));
        _interior.add(new Point(574, 402));
        _interior.add(new Point(561, 412));
        _interior.add(new Point(538, 421));
        _interior.add(new Point(515, 420));
        _interior.add(new Point(492, 416));
        _interior.add(new Point(466, 412));
        _interior.add(new Point(453, 413));
        _interior.add(new Point(431, 418));
        _interior.add(new Point(409, 424));
        _interior.add(new Point(394, 428));
        _interior.add(new Point(370, 442));
        _interior.add(new Point(353, 459));
        _interior.add(new Point(334, 474));
        _interior.add(new Point(294, 485));
        _interior.add(new Point(269, 485));
        _interior.add(new Point(253, 477));
        _interior.add(new Point(239, 466));
        _interior.add(new Point(230, 450));
        _interior.add(new Point(222, 423));
        _interior.add(new Point(215, 400));
        _interior.add(new Point(212, 381));
        _interior.add(new Point(202, 351));
        _interior.add(new Point(194, 321));
        _interior.add(new Point(180, 295));
        _interior.add(new Point(166, 270));
        _interior.add(new Point(154, 245));
        _interior.add(new Point(154, 217));
        _interior.add(new Point(159, 198));
        _interior.add(new Point(168, 178));
        _interior.add(new Point(184, 155));
        _interior.add(new Point(202, 141));
        _interior.add(new Point(225, 123));
        _interior.add(new Point(243, 110));
        _interior.add(new Point(275, 102));
        _interior.add(new Point(302, 100));
        _interior.add(new Point(302, 100));
        ArrayList<Point> temp = new ArrayList<>();
        temp.add(new Point(408, 58));
        temp.add(new Point(408, 98));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(487, 60));
        temp.add(new Point(475, 99));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(575, 74));
        temp.add(new Point(547, 117));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(632, 127));
        temp.add(new Point(572, 139));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(627, 187));
        temp.add(new Point(571, 175));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(619, 228));
        temp.add(new Point(564, 225));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(632, 279));
        temp.add(new Point(584, 298));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(654, 348));
        temp.add(new Point(598, 343));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(632, 410));
        temp.add(new Point(590, 385));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(551, 488));
        temp.add(new Point(523, 422));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(453, 470));
        temp.add(new Point(455, 414));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(394, 476));
        temp.add(new Point(367, 447));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(340, 524));
        temp.add(new Point(312, 479));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(203, 517));
        temp.add(new Point(238, 470));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(219, 412));
        temp.add(new Point(152, 422));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(150, 352));
        temp.add(new Point(195, 329));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(165, 268));
        temp.add(new Point(97, 273));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(155, 203));
        temp.add(new Point(109, 172));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(203, 143));
        temp.add(new Point(164, 84));
        _checkpoints.add(temp);
        temp = new ArrayList<>();
        temp.add(new Point(263, 102));
        temp.add(new Point(257, 66));
        _checkpoints.add(temp);
    }

    private static Double calculateGradient(Point p1, Point p2){
        Double m = null;
        if(p1.x != p2.x) m = Double.valueOf((p1.y - p2.y) / (p1.x - p2.x));
        return m;
    }
    private static Point calculateIntersectPoint(Point p1, Point p2, Point p3, Point p4){
        ArrayList<Point> ps = Game.getIntersectPoint(p1, p2, p3, p4);
        if(ps != null){
            Double width1 = p2.x - p1.x;
            Double height1 = p2.y - p1.y;
            Double width2 = p4.x - p3.x;
            Double height2 = p4.y - p3.y;
            width1 = (width1 < 0) ? -width1 : width1;
            height1 = (height1 < 0) ? -height1 : height1;
            width2 = (width2 < 0) ? -width2 : width2;
            height2 = (height2 < 0) ? -height2 : height2;
            width1 = (width1 < 1) ? 1 : width1;
            height1 = (height1 < 1) ? 1 : height1;
            width2 = (width2 < 1) ? 1 : width2;
            height2 = (height2 < 1) ? 1 : height2;
            for(Point p : ps){
                boolean r1 = false;
                boolean r2 = false;

                if(p.x >= p1.x && p.x <= p1.x + width1 && p.y >= p1.y && p.y <= p1.y + height1) r1 = true;
                if(p.x >= p2.x && p.x <= p2.x + width2 && p.y >= p2.y && p.y <= p2.y + height2) r2 = true;

                if(r1 && r2) return p;
                return null;
            }
        }
        return null;
    }
    private static Double calculateYAxisIntersect(Point p, Double m){
        return p.y - (m * p.x);
    }
    private static ArrayList<Point> getIntersectPoint(Point p1, Point p2, Point p3, Point p4){
        ArrayList<Point> result = new ArrayList<>();
        Double m1 = Game.calculateGradient(p1, p2);
        Double m2 = Game.calculateGradient(p3, p4);
        if(m1 != m2){
            if(m1 != null && m2 != null){
                Double b1 = Game.calculateYAxisIntersect(p1, m1);
                Double b2 = Game.calculateYAxisIntersect(p3, m2);
                result.add(new Point((b2 - b1) / (m1 - m2), (m1 * (b2 - b1) / (m1 - m2)) + b1));
            } else {
                if(m1 == null){
                    Double b2 = Game.calculateYAxisIntersect(p3, m2);
                    result.add(new Point(p1.x, (m2 * p1.x) + b2));
                } else {
                    Double b1 = Game.calculateYAxisIntersect(p1, m1);
                    result.add(new Point(p3.x, (m1 * p3.x) + b1));
                }
            }
            return result;
        } else {
            Double b1 = null;
            Double b2 = null;
            if(m1 != null) b1 = Game.calculateYAxisIntersect(p1, m1);
            if(m2 != null) b2 = Game.calculateYAxisIntersect(p3, m2);
            if(b1 == b2){
                result.add(p1);
                result.add(p2);
                result.add(p3);
                result.add(p4);
                return result;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        GeneticAlgorithm ga = new GeneticAlgorithm();
        ArrayList<Car> cars = new ArrayList<>();

        for(int i=0; i<Game.NBR_CAR; i++) cars.add(new Car());

        ArrayList<Point> exterior = new ArrayList<>();
        ArrayList<Point> interior = new ArrayList<>();
        ArrayList<ArrayList<Point>> checkpoints = new ArrayList<>();
        Game.populate(exterior, interior, checkpoints);

        ArrayList<Float> bests = new ArrayList<>();
        ArrayList<Float> means = new ArrayList<>();

        int gen = 0;
        while(gen < Game.NBR_GENERATION){
            int timeRace = 0;
            while(timeRace < Game.TIME_RACE){
                boolean tokenStop = true;

                for(Car car : cars) {
                    if (!car.alive) continue;

                    double dx1 = Math.cos((car.orientation - 90) * Math.PI / 180);
                    double dy1 = Math.sin((car.orientation - 90) * Math.PI / 180);
                    double dx2 = Math.cos((car.orientation - 45) * Math.PI / 180);
                    double dy2 = Math.sin((car.orientation - 45) * Math.PI / 180);
                    double dx3 = Math.cos((car.orientation - 135) * Math.PI / 180);
                    double dy3 = Math.sin((car.orientation - 135) * Math.PI / 180);

                    Double dist1 = null;
                    Double dist2 = null;
                    Double dist3 = null;
                    Double dist4 = null;
                    Point p1 = null;
                    Point p2 = null;
                    Point p3 = null;
                    Point p4 = null;
                    for(int i=0; i<interior.size(); i++){
                        Point s = interior.get(i);
                        Point e = (i != interior.size()-1) ? interior.get(i+1) : interior.get(0);
                        if(p1 == null)
                            p1 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x + dx1*Car.VIEW_RANGE, car.y + dy1*Car.VIEW_RANGE),
                                    s, e);
                        if(p2 == null)
                            p2 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x + dx2*Car.VIEW_RANGE, car.y + dy2*Car.VIEW_RANGE),
                                    s, e);
                        if(p3 == null)
                            p3 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x + dx3*Car.VIEW_RANGE, car.y + dy3*Car.VIEW_RANGE),
                                    s, e);
                        if(p4 == null)
                            p4 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x - dx1*Car.VIEW_RANGE, car.y - dy1*Car.VIEW_RANGE),
                                    s, e);
                    }
                    for(int i=0; i<exterior.size(); i++){
                        Point s = exterior.get(i);
                        Point e = (i != exterior.size()-1) ? exterior.get(i+1) : exterior.get(0);
                        if(p1 == null)
                            p1 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x + dx1*Car.VIEW_RANGE, car.y + dy1*Car.VIEW_RANGE),
                                    s, e);
                        if(p2 == null)
                            p2 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x + dx2*Car.VIEW_RANGE, car.y + dy2*Car.VIEW_RANGE),
                                    s, e);
                        if(p3 == null)
                            p3 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x + dx3*Car.VIEW_RANGE, car.y + dy3*Car.VIEW_RANGE),
                                    s, e);
                        if(p4 == null)
                            p4 = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                    new Point(car.x - dx1*Car.VIEW_RANGE, car.y - dy1*Car.VIEW_RANGE),
                                    s, e);
                    }

                    if(p1 == null) dist1 = (double) Car.VIEW_RANGE;
                    else dist1 = Math.sqrt(Math.pow(car.x - p1.x, 2) + Math.pow(car.y - p1.y, 2));
                    if(p2 == null) dist2 = (double) Car.VIEW_RANGE;
                    else dist2 = Math.sqrt(Math.pow(car.x - p2.x, 2) + Math.pow(car.y - p2.y, 2));
                    if(p3 == null) dist3 = (double) Car.VIEW_RANGE;
                    else dist3 = Math.sqrt(Math.pow(car.x - p3.x, 2) + Math.pow(car.y - p3.y, 2));
                    if(p4 == null) dist4 = (double) Car.VIEW_RANGE;
                    else dist4 = Math.sqrt(Math.pow(car.x - p4.x, 2) + Math.pow(car.y - p4.y, 2));

                    if(dist1 < 20 || dist2 < 20 || dist3 < 20 || dist4 < 20){
                        System.out.println("Someone's dead");
                        car.alive = false;
                        continue;
                    }

                    for(int i=0; i < checkpoints.size(); i++){
                        Point s = checkpoints.get(i).get(0);
                        Point e = checkpoints.get(i).get(1);

                        Point p = Game.calculateIntersectPoint(new Point(car.x, car.y),
                                new Point(car.x + dx1*Car.VIEW_RANGE, car.y + dy1*Car.VIEW_RANGE),
                                s, e);
                        if(p != null){
                            if(Math.sqrt(Math.pow(car.x - p.x, 2) + Math.pow(car.y - p.y, 2)) < 11 && i == car.nextCheckpointID){
                                car.nextCheckpointID++;
                                car.totalDistanceAfterCheckpoint = 0;
                            }
                        }
                    }

                    car.x += dx1*car.speed;
                    car.y += dy1*car.speed;
                    if(car.speed > 0) car.totalDistanceAfterCheckpoint += Math.sqrt(Math.pow(dx1, 2) + Math.pow(dy1, 2));
                    car.totalDistance = car.nextCheckpointID * 100 + car.totalDistanceAfterCheckpoint;

                    Double speed_normalized = (double) (car.speed + 5) / 15;
                    Double dist1_normalized = (double) dist1 / Car.VIEW_RANGE;
                    Double dist2_normalized = (double) dist2 / Car.VIEW_RANGE;
                    Double dist3_normalized = (double) dist3 / Car.VIEW_RANGE;
                    ArrayList<Double> inputs = new ArrayList<Double>(Arrays.asList(speed_normalized,
                                                                                    dist1_normalized,
                                                                                    dist2_normalized,
                                                                                    dist3_normalized));
                    ArrayList<Double> controls = car.nn.evaluate(inputs);
                    if(controls.get(0) >= Game.THRESHOLD) car.orientation -= 5;
                    if(controls.get(1) >= Game.THRESHOLD) car.orientation += 5;
                    if(controls.get(2) >= Game.THRESHOLD) car.speed = (car.speed + 1 > 10) ? 10 : car.speed+1;
                    if(controls.get(3) >= Game.THRESHOLD) car.speed = (car.speed - 0.5 < -5) ? -5 : (float) (car.speed - 0.5);

                    if(car.x != car.lastX || car.y != car.lastY) tokenStop = false;

                    car.nn.fitness = car.fitness();
                }
                System.out.println(cars.get(0));
                if(tokenStop) break;
                timeRace++;
            }

            ArrayList<NeuralNetwork> individuals = new ArrayList<>();
            for(Car car : cars) individuals.add(new NeuralNetwork(car.nn));
            ga.evolve(individuals);
            Iterator<Car> carIterator = cars.iterator();
            Iterator<NeuralNetwork> neuralIterator = ga.nextGeneration.iterator();
            while(carIterator.hasNext() && neuralIterator.hasNext()) carIterator.next().nn = neuralIterator.next();

            float bestDistance = 0;
            float sumTotal = 0;
            for(Car car : cars){
                bestDistance = Math.max(bestDistance, car.totalDistance);
                sumTotal += car.totalDistance;
                car.reinitialization();
            }
            bests.add(bestDistance);
            means.add(sumTotal / cars.size());
            System.out.println("Generation " + gen++ + ": best score=" + bestDistance);
        }
    }
}
