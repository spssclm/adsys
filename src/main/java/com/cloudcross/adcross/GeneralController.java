package com.cloudcross.adcross;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class GeneralController {

//	@RequestMapping(value="index.do")
//	public void index_jsp(Model model){  
//        model.addAttribute("ylf", "hi!");  
//        System.out.println("index.jsp");  
//    }
	
	@RequestMapping(value="succ.do")
	public void index_jsp(Model model){  
        model.addAttribute("ylf", "hi!");  
        System.out.println("index.jsp");  
    }
	
//	@RequestMapping("/succ")
//	public String succ(@RequestParam Map<String, Object> paraMap,Model model,
//    		RedirectAttributes redirectAttributes) {
//    	long id = Long.valueOf(paraMap.get("id").toString());
//        CustMaterial custMater = custMaterialService.findByIdLocal(id);
//        custMater.setAuditStatus(1);
//        User loginUser = (User)getSession().getAttribute("loginUser");
////        User loginUser=getLoginUser();
//        custMater.setAuditUserId(loginUser.getId());
//        custMaterialService.editCustMaterStatusLocal(custMater);
//        adagencyUserSucc(custMater);
////        custApisHandler(custMater);
//        sendCust(custMater);
//	}
}
