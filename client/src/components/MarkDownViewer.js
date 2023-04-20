// Toast-UI Viewer 임포트
import "@toast-ui/editor/dist/toastui-editor-viewer.css";
import "prismjs/themes/prism.css";

function MarkdownViewer({ content }) {
  const html = content;
  console.log(html);
  return <div dangerouslySetInnerHTML={{ __html: html }} />;
}

export default MarkdownViewer;
