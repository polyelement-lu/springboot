package com.free.web;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.free.model.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="/users")
public class UserController {
	 // 创建线程安全的map
	 static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	 
	 @ApiOperation(value="获取用户列表",notes="")
//	 @RequestMapping(value="/",method=RequestMethod.GET)
	 @GetMapping(value="/") // 组合注解
	 public List<User> getUserList(){
		 List<User> list = new ArrayList<>(users.values());
		 return list;
	 }
	 @ApiOperation(value="创建用户",notes="根据user对象创建用户")
	 @ApiImplicitParam(name="user",value="用户详细实体user",required=true,dataType="User")
//	 @RequestMapping(value="/",method=RequestMethod.POST)
	 @PostMapping(value="/")
	 public String postUser(@ModelAttribute User user){
		 // 创建User
		 users.put(user.getId(), user);
		 return "success";
	 }
	 @ApiOperation(value="获取用户详细信息",notes="根据url的id获取用户详细信息")
	 @ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long")
//	 @RequestMapping(value="/{id}",method=RequestMethod.GET)
	 @GetMapping(value="/{id}")
	 public User postUser(@PathVariable Long id){
		 // 根据id获取User
		 return users.get(id);
	 }
	 @ApiOperation(value="更新用户详细信息",notes="根据url的id更新指定用户，并根据传过来的user更新用户详细信息")
	 @ApiImplicitParams({
		 @ApiImplicitParam(name="id",value="用户Id",required=true,dataType="Long"),
		 @ApiImplicitParam(name="user",value="用户详细实体user",required=true,dataType="User")
	 })
//	 @RequestMapping(value="/{id}",method=RequestMethod.PUT)
	 @PutMapping(value="/{id}") // 组合注解
	 public String updateUser(@PathVariable Long id,@ModelAttribute User user){
		 // 更新User信息
		 User u = users.get(id);
		 u.setName(user.getName());
		 u.setAge(user.getAge());
		 users.put(id, u);
		 return "success";
	 }
	 @ApiOperation(value="删除用户",notes="根据url的id删除指定用户")
	 @ApiImplicitParam(name="id",value="用户Id",required=true,dataType="Long")
//	 @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	 @DeleteMapping(value="/{id}")
	 public String delUser(@PathVariable Long id){
		 // 删除User信息
		 users.remove(id);
		 return "success";
	 }
}
