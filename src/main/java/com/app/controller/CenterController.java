package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.dto.center.CenterDTO;
import com.app.dto.center.CenterFollowDTO;
import com.app.service.center.ICenterService;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/center")
@RestController
public class CenterController {
	
	@Autowired
	private ICenterService centerService;
	
	@GetMapping(value = "/centers")
	public ResponseEntity<List<CenterDTO>> getAllLevels(@RequestParam(required = false) String centerName, 
	        @RequestParam(required = false) Integer cityId, @RequestParam(required = false) List<Integer> listSports,
	        UriComponentsBuilder builder, HttpServletRequest request, HttpServletResponse response) {

	    return new ResponseEntity<>(centerService.getCenters(centerName, cityId, listSports), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<CenterDTO> getCenter(@RequestParam(required = false) Integer centerId,
			UriComponentsBuilder builder, HttpServletRequest request, HttpServletResponse response) {

		return new ResponseEntity<>(centerService.getCenter(centerId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/follow")
	public ResponseEntity<CenterDTO> followCenter(@RequestBody CenterFollowDTO followRequest, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(centerService.followCenter(followRequest.getPlayerId(), followRequest.getCenterId()), HttpStatus.OK);
	}

	@PostMapping(value = "/unfollow")
	public ResponseEntity<CenterDTO> unfollowCenter(@RequestBody CenterFollowDTO unfollowRequest, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(centerService.unfollowCenter(unfollowRequest.getPlayerId(), unfollowRequest.getCenterId()), HttpStatus.OK);
	}
}
