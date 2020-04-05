package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @RequestMapping("/zad1")
    public String getCalcDodajPostForm() {
        return "calcGet";
    }

    @RequestMapping("/zad1/calculate")
    public String getPostResult(Model model, Integer x, Integer y) {
        String result = String.format("%d + %d = %d", x, y, x + y);
        model.addAttribute("result", result);

        return "calcPost";
    }

    @RequestMapping("/zad2")
    public String getCalcZad2PostForm() {
        return "calcZad2Get";
    }

    @RequestMapping("/zad2/calculate")
    public String getZad2PostResult(Model model, Integer x, Integer y, String operation) {
        int resultValue = getOperationResult(x, y, operation);
        String result = String.format("%d %s %d = %d", x, operation, y, resultValue);
        model.addAttribute("result", result);

        return "calcPost";
    }

    @RequestMapping("/zad3")
    public String getCalcZad3PostForm() {
        return "calcZad3Get";
    }

    @RequestMapping("/zad3/calculate")
    public String getZad3PostResult(Model model, CalculatorForm calculatorForm) {
        int resultValue = getOperationResult(calculatorForm.getX(), calculatorForm.getY(), calculatorForm.getOperator());
        String result = String.format("%d %s %d = %d", calculatorForm.getX(), calculatorForm.getOperator(), calculatorForm.getY(), resultValue);
        model.addAttribute("result", result);

        return "calcPost";
    }

    private int getOperationResult(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                throw new IllegalStateException("Operation not found: " + operator);
        }
    }

}
