import java.time.LocalDate;
import java.time.Period;
public class GymMemberNepal {
    // Attributes
     String memberName;
     String membershipType;  
     double monthlyFee;
     LocalDate joinDate;
     boolean isStudent;

    // Constructor
    public GymMemberNepal(String memberName, String membershipType, double monthlyFee, LocalDate joinDate, boolean isStudent) {
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.monthlyFee = monthlyFee;
        this.joinDate = joinDate;
        this.isStudent = isStudent;
    }

    // Calculate annual fee with 13% VAT
    public double calculateAnnualFee(){
        double annual = monthlyFee * 12;
        double vat = annual * 0.13;
        return annual + vat;
    }

    // Discounted monthly fee for students/seniors
    public double getDiscountedFee(double discountPercent){
        return monthlyFee - (monthlyFee * discountPercent / 100);
    }
    
    // Eligible for loyalty discount if member for more than 6 months
    public boolean isEligibleForDiscount(){
        Period duration = Period.between(joinDate, LocalDate.now());
        int totalMonths = duration.getMonths() + (duration.getYears() * 12);
        return totalMonths > 6;
    }

    // Display member info in Nepali style
    public void displayMemberInfo(){
        System.out.println("--------------------------------------------------");
        System.out.println("सदस्यको नाम: " + memberName);
        System.out.println("मेम्बरशिप प्रकार: " + membershipType);
        System.out.println("मासिक शुल्क: Rs. " + monthlyFee);
        System.out.println("जोडिएको मिति: " + joinDate);
        System.out.println("६ महिनाभन्दा बढी सदस्यता? " + (isEligibleForDiscount() ? "हो" : "होइन"));
        System.out.println("वार्षिक शुल्क (VAT सहित): Rs. " + calculateAnnualFee());
        System.out.println("विद्यार्थी: " + isStudent);
        System.out.println("--------------------------------------------------");
    }

    // Main method to test
    public static void main(String[] args){
        // object creation 
        GymMemberNepal basic = new GymMemberNepal("Himal", "Monthly", 1500, LocalDate.of(2024, 5, 10),true);
        GymMemberNepal premium = new GymMemberNepal("Sagar", "Quarterly", 2500, LocalDate.of(2023, 12, 1),false); 
        GymMemberNepal vip = new GymMemberNepal("Elon", "Yearly", 4000, LocalDate.of(2023, 3, 24),true);
        
        //calling method
        basic.displayMemberInfo();
        premium.displayMemberInfo();
        vip.displayMemberInfo();
        
        //dicount for student
        double discount = basic.getDiscountedFee(0.5);
        System.out.println("discount for Himal: " + discount);
    }
}