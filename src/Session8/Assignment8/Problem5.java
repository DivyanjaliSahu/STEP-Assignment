package Session8.Assignment8;

import java.util.*;
import java.time.LocalDate;
import java.util.function.Function;

public class Problem5 {

    interface SubscriptionPlan {
        LocalDate getRenewalDate(LocalDate startDate);
    }

    static class BasicPlan implements SubscriptionPlan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(30);
        }
    }

    static class StandardPlan implements SubscriptionPlan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(90);
        }
    }

    static class PremiumPlan implements SubscriptionPlan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, SubscriptionPlan> plans = new HashMap<>();
        plans.put("BASIC", new BasicPlan());
        plans.put("STANDARD", new StandardPlan());
        plans.put("PREMIUM", new PremiumPlan());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan = plans.get(type);
            LocalDate renewalDate = plan.getRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}

