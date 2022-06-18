/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.level.common.file.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.level.vo.FileVO;

@Mapper
public interface FileMapper {

	
	int insert(FileVO fileVO) throws Exception;
	
	int delete(FileVO fileVO) throws Exception;
	
	List<FileVO> selectFileList(FileVO fileVO) throws Exception;
	
	FileVO getFile(FileVO fileVO) throws Exception;
	

} 
