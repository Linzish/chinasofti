package com.chinasofti.postbar.mypost.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.postbar.mypost.basic.BasicController;
import com.chinasofti.postbar.mypost.dto.PostDto;
import com.chinasofti.postbar.mypost.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping(value="/myPostController")
public class MyPostController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(MyPostController.class);

    @Autowired
    private PostService postService;

    @ModelAttribute
    @RequestMapping(value="/getMyPostList")
    public void getMyPostList(HttpServletResponse response, HttpServletRequest request, String postTitle, int pageIndex, int everyPageDataCount) {
        logger.info("calling MyPostController [getMyPostList]");
        HttpSession session = request.getSession();
        JSONObject json = new JSONObject();
        json.put("message", "");
        if (sessionTimeout(request)) {
            json.put("message", "页面过期，请重新登录");
        } else {
            String userUUID = (String) session.getAttribute("id");
            json.put("postAllNum", 0);
            json.put("allPage", 0);
            json.put("pageIndex", 0);
            json.put("postList", "");


            int postAllNum = postService.getPostAllNum(postTitle, userUUID);
            json.put("postAllNum", postAllNum);

            if (postAllNum > 0) {
//				// 总页数变量
                int allPage = 1;
                // 计算总页数
                if ((postAllNum % everyPageDataCount) == 0) {
                    allPage = postAllNum / everyPageDataCount;
                } else {
                    allPage = postAllNum / everyPageDataCount + 1;
                }
                // 防止页码越界
                if (pageIndex < 0) {
                    pageIndex = 0;
                } else if (pageIndex >= allPage) {
                    pageIndex = allPage - 1;
                }


                json.put("allPage", allPage);
                json.put("pageIndex", pageIndex);

                List<PostDto> list = postService.selectPostList(postTitle, pageIndex * everyPageDataCount, everyPageDataCount, userUUID);

                json.put("postList", list);
            }

        }

//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//		JSONObject jsonObject = JSONObject.fromObject(json,jsonConfig);

        this.writeJson(json.toString(), response);
    }

}
