package com.xuecheng.auth.filter;

import com.alibaba.fastjson.JSON;
import com.xuecheng.ucenter.model.dto.TokenDto;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @Description TODO
 * @ClassName MyFilter
 * @Author 龙涛05664416459
 * @Date 2023/4/22 23:01
 **/
@Component
public class MyFilter implements Filter {

    @Autowired
    RedisTemplate redisTemplate;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //转换响应为HttpServletResponseWrapper
        MyHttpServletResponseWrapper myResponse = new MyHttpServletResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, myResponse);
        //获取响应体数据
        byte[] responseData = myResponse.getResponseData();
        String responseBody = new String(responseData, response.getCharacterEncoding());
        //处理响应体数据
        TokenDto tokenDto = JSON.parseObject(responseBody, TokenDto.class);
        ValueOperations redis = redisTemplate.opsForValue();
//        Object principalObj = tokenDto.getAccess_token();
//            //取出用户身份信息
//            String principal = principalObj.toString();
//            //将json转成对象
//            XcUser user = JSON.parseObject(principal, XcUser.class);
//
        chain.doFilter(request,response);
    }

    //自定义HttpServletResponseWrapper
    public static class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {

        private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        private PrintWriter writer = new PrintWriter(outputStream);

        public MyHttpServletResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyServletOutputStream(outputStream);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return writer;
        }

        public byte[] getResponseData() {
            writer.flush();
            return outputStream.toByteArray();
        }
    }

    //自定义ServletOutputStream
    public static class MyServletOutputStream extends ServletOutputStream {

        private OutputStream outputStream;

        public MyServletOutputStream(OutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void write(int b) throws IOException {
            outputStream.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            outputStream.write(b, off, len);
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }
    }

}



