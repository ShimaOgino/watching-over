import { Link } from "react-router-dom";

export const Header = () => {
  return (
    <div>
      <div>
        <Link to="/main/page1">page1</Link>

        <Link to="/main/page2">page2</Link>
      </div>
    </div>
  );
};
