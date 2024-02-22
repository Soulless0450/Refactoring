public class HDD {
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Просходит копирование данных с диска");
        }
        else{
            System.out.println("Вставьте диск с данными");
        }
    }
}
