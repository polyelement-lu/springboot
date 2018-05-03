package com.free.ldmspringbooot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.free.web.UserController;

import ch.qos.logback.core.status.Status;
import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import springfox.documentation.staticdocs.SwaggerResultHandler;

@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocsTest {
	private String snippetDir = "target/generated-snippets";
	
	private String outputDir = "target/asciidoc";
	
	@Autowired
	private MockMvc mvc;
	
//	@Before
//	public void setUp() throws Exception{
//		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
//	}
	
	@After
	public void test() throws Exception{
		// 得到swagger.json写入到outputdir目录
		mvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
		   .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
		   .andExpect(status().isOk())
		   .andReturn();
		// 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
		Swagger2MarkupConverter.from(outputDir+"/swagger.json")
							   .withPathsGroupedBy(GroupBy.TAGS)
							   .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
							   .withExamples(snippetDir)
							   .build().intoFolder("src/docs/markdown/generated");
//							   .intoFolder(outputDir);// 输出

	}
	@Test
	public void testApi() throws Exception{
		MockHttpServletRequestBuilder requestBuilder = get("/users/");
		System.out.println(requestBuilder);
		// 1.检查user列表，为null
		mvc.perform(requestBuilder.accept(MediaType.APPLICATION_JSON))
		   .andExpect(status().isOk())
		   .andDo(document("getUsers", Preprocessors.preprocessResponse(Preprocessors.prettyPrint())));
	}
}
