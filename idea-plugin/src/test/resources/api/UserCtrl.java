package com.itangcent.api;

import com.itangcent.annotation.Public;
import com.itangcent.api.BaseController;
import com.itangcent.model.IResult;
import com.itangcent.model.Result;
import com.itangcent.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * apis about user
 * access user info
 *
 * @module users
 */
@RestController
@RequestMapping(value = "user")
public class UserCtrl extends BaseController {

    /**
     * say hello
     * not update anything
     */
    @Public
    @RequestMapping(value = "/greeting")
    public String greeting() {
        return "hello world";
    }

    /**
     * get user info
     *
     * @param id user id
     * @folder update-apis
     * @undone
     */
    @Deprecated
    @GetMapping("/get/{id}")
    public IResult get(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * create an user
     */
    @PostMapping("/add")
    public Result<UserInfo> create(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * update user info
     */
    @PutMapping("/update")
    public Result<UserInfo> update(@ModelAttribute UserInfo userInfo) {
        return Result.success(userInfo);
    }

}
