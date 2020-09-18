package com.seavus.talent.WebCalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {


    @RequestMapping(path = "/calculate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String calculate(@RequestParam String operandOne, @RequestParam String operator, @RequestParam String operandTwo) {
        String errorMsg = "";
        if (operator.equals("+")) {
            return String.valueOf(Integer.valueOf(operandOne) + Integer.valueOf(operandTwo));
        } else if (operator.equals("-")) {
            return String.valueOf(Integer.valueOf(operandOne) - Integer.valueOf(operandTwo));
        } else if (!operator.equals("+") && !operator.equals("-")) {
            errorMsg = "Error: An invalid operator was inserted.";
            return errorMsg;
        }
        errorMsg = "An error occurred :/";
        return errorMsg;
    }
}
