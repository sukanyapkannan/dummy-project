package com.sinergia.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinergia.dao.BlogDao;
import com.sinergia.model.Blog;
import com.sinergia.model.User;

@RestController
@RequestMapping("/blog")
public class BlogController
{
@Autowired
BlogDao bdao;

@RequestMapping(value="/addBlog",method=RequestMethod.POST)
public ResponseEntity<Blog> addBlog(@RequestBody Blog blog)
{
	
	bdao.addBlog(blog);
	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	
}
}
