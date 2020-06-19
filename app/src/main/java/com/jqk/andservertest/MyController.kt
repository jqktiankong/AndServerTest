package com.jqk.andservertest

import com.yanzhenjie.andserver.annotation.GetMapping
import com.yanzhenjie.andserver.annotation.ResponseBody
import com.yanzhenjie.andserver.annotation.RestController


@RestController
class MyController {
    @ResponseBody
    @GetMapping("/project/info")
    fun newInfo(): String? {
        return "I am new api."
    }
}