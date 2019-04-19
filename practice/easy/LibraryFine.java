package easy;

public class LibraryFine {

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        int fine = 0;
        int yearDiff    = y1 - y2;
        int monthDiff   = m1 - m2;
        int dayDiff     = d1 - d2;

        if (yearDiff < 0){
            fine = 0;
        } else if (yearDiff == 0){

            if (monthDiff < 0){
                fine = 0;
            } else if (monthDiff == 0){

                if (dayDiff < 0){
                    fine = 0;
                } else if (dayDiff == 0){
                    fine = 0;
                } else if (dayDiff > 0){
                    fine = 15 * dayDiff;
                }
            } else if (monthDiff > 0){
                fine = 500 * monthDiff;
            }
        } else if (yearDiff > 0){
            fine = 10000;
        }
        return fine;
    }

}
