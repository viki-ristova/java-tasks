package com.seavus.talent.WebCalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @RequestMapping(path = "/calculate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String greet(@RequestParam String operandOne, @RequestParam String operator, @RequestParam String operandTwo) {
        if (operator.equals("+")) {
            return String.valueOf(Integer.valueOf(operandOne) + Integer.valueOf(operandTwo));
        } else if (operator.equals("-")) {
            return String.valueOf(Integer.valueOf(operandOne) - Integer.valueOf(operandTwo));
        } else
            return "An error occurred :/";
    }
}
