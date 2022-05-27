package com.example.demo;


import com.example.demo.dto.Board;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping(value = "/homepage")
    public String homepage() {
        //게시글 입력

        return "homepage";
    }


    @PostMapping(value = "/next")
    public String write(HttpServletRequest request, HttpServletResponse response, Model model) {
        // DB Insert
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        Map<String, String> inf = new HashMap<String, String>();

        inf.put("title", title);
        inf.put("writer", writer);
        inf.put("content", content);


        int insrt = testService.setAllDataList(inf);


//        List<Board> result = new ArrayList<Board>();
//        result = testService.getAllDataList();
//
//        model.addAttribute("articles", result);


        return "redirect:/list?page=0";
    }

    @GetMapping(value = "/list")
    public String borderlist(Model model, HttpServletRequest request) throws Exception {
        //페이지 n개씩 띄우기
        double pageSetView = 10;
        Map<String, Integer> pageset = new HashMap<String, Integer>();
        int page = Integer.parseInt(request.getParameter("page"));

        int pv = (int) pageSetView;
        int repage = page * pv;

        pageset.put("page", repage);
        pageset.put("pv", pv);


        System.out.println(page);

        //리스트 호출 게시판 목록 생성
        List<Board> result = new ArrayList<Board>();
        result = testService.getAllDataList(pageset);
        model.addAttribute("articles", result);

        int totalCount = testService.pageSlid();
        int pageCount = (int) Math.ceil(totalCount / pageSetView);

        List<Integer> pageCountList = new ArrayList<>();
        for (int i = 0; i < pageCount; i++) {
            pageCountList.add(i);}
        model.addAttribute("pageCount", pageCountList);
        return "borderlist1";
    }
    @GetMapping("/board-open")
    public String openBoardDetail(@RequestParam int CRUD_idx, Model model) throws Exception {

        Board board = testService.getData(CRUD_idx);
        model.addAttribute("article", board);

        return "board-open";
    }

    @PostMapping("/updateindex")
    public String update(Model model, HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");
        String Crud_idx = request.getParameter("idx");

        Map<String, String> upinf = new HashMap<String, String>();

        upinf.put("title", title);
        upinf.put("writer", writer);
        upinf.put("content", content);
        upinf.put("CRUD_idx", Crud_idx);

        int updateData = testService.updateData(upinf);
        return "redirect:/list?page=0";
    }
    @PostMapping("/delData")
    public String delData(Model model, HttpServletRequest request) {
        String CRUD_idx = request.getParameter("idx");
        Map<String, String> delinf = new HashMap<String, String>();

        delinf.put("CRUD_idx", CRUD_idx);

        int delData = testService.delData(delinf);

        return "redirect:/list?page=0";
    }
}