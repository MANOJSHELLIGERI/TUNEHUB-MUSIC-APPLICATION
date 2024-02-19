package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;
import com.example.demo.services.SongService;
import com.example.demo.services.playlistService;


@Controller
public class PlaylistController {

	@Autowired
	SongService sgService;      //01 

	@Autowired
	playlistService plService;  //02

	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model)
	{
		List<Song> songList = sgService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";     //html page
	}

	@PostMapping("/addPlaylist")    // from html it camed 
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		// updating playlisttable
		plService.addPlaylist(playlist);
		System.out.println(playlist);

		// updating song table 
		List<Song> songList = playlist.getSongs();
		for(Song s : songList)
		{
			s.getPlaylists().add(playlist);
			sgService.updateSong(s);
		}
		return "adminhome";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewplaylists(Model model) {
		List <Playlist> allPlaylists = plService.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayplaylists";
	}
	
	
	
	
	
	
}
