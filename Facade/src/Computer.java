public class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();
    void copy(){
        dvd.load();
        power.off();
        hdd.copyFromDVD(dvd);
    }
}
