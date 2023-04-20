// import MDEditor from "@uiw/react-md-editor";
import { useRef } from "react";
import { Editor } from "@toast-ui/react-editor";
import codeSyntaxHighlight from "@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight-all";
// 이걸 불러오기만 해도 하이라이팅이 됨
import "prismjs/themes/prism.css";

import "@toast-ui/editor/dist/toastui-editor.css";

function MarkDown({ editorRef }) {
  // preview="edit" 는 미리보기가 없는 모드!
  // MdEditor
  console.log(editorRef);
  return (
    // <MDEditor
    //   preview="edit"
    //   value={editorBind.value}
    //   onChange={editorBind.onChange}
    // />

    <Editor
      ref={editorRef}
      plugins={[codeSyntaxHighlight]}
      placeholder="내용을 입력해주세요."
      initialValue=" "
      previewStyle="vertical" // 미리보기 스타일 지정
      height="300px" // 에디터 창 높이
      // initialEditType="wysiwyg" // 초기 입력모드 설정(디폴트 markdown)
      toolbarItems={[
        // 툴바 옵션 설정
        ["heading", "bold", "italic", "strike"],
        ["hr", "quote"],
        ["ul", "ol", "task", "indent", "outdent"],
        ["table", "image", "link"],
        ["code", "codeblock"],
      ]}
    />
  );
}

function Input({ value }) {
  return <input type="text" value={value.curValue} onChange={value.onChange} />;
}

function TextArea({ value }) {
  return (
    <textarea type="text" value={value.curValue} onChange={value.onChange} />
  );
}

export { MarkDown, Input, TextArea };
