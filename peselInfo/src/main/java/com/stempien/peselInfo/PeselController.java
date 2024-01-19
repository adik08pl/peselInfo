package com.stempien.peselInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeselController {
    @GetMapping("/pesel")
    @ResponseBody
    public String hello(@RequestParam String pesel) {
        String answer="";
        String tab[] = pesel.split("");
        if(tab.length!=11)
            return "Niepoprawy pesel";
        Integer peselHelp = ((Integer.valueOf(tab[0])*1)+(Integer.valueOf(tab[1])*3)+(Integer.valueOf(tab[2])*7)+(Integer.valueOf(tab[3])*9)+(Integer.valueOf(tab[4])*1)+(Integer.valueOf(tab[5])*3)+(Integer.valueOf(tab[6])*7)+(Integer.valueOf(tab[7])*9)+(Integer.valueOf(tab[8])*1)+(Integer.valueOf(tab[9])*3))%10;
        if(10-peselHelp!=Integer.valueOf(tab[10]))
            return "Niepoprawy pesel";
        if(tab[2].equals("0")){
            answer+="Data urodzenia: 19"+tab[0]+tab[1]+"."+tab[2]+tab[3]+"."+tab[4]+tab[5];
        }
        else if(tab[2].equals("2")){
            answer+="Data urodzenia: 20"+tab[0]+tab[1]+"."+(Integer.valueOf(tab[2])-2)+tab[3]+"."+tab[4]+tab[5];
        }else if(tab[2].equals("4")){
            answer+="Data urodzenia: 21"+tab[0]+tab[1]+"."+(Integer.valueOf(tab[2])-4)+tab[3]+tab[4]+tab[5];
        }
        if(Integer.valueOf(tab[9])%2==0){
            answer+="\n Płeć: kobieta";
        }
        else{
            answer+="\n Płeć: mężczyzna";
        }
        return answer;
    }
}
