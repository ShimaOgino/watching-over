import { useState } from "react";
import { useNavigate } from "react-router-dom";

export const Login = () => {
  const navigate = useNavigate();

  const [form, setForm] = useState({ name: "", pass: "" });
  const handleChange = (input) => (e) => {
    setForm({ ...form, [input]: e.target.value });
  };

  return (
    <div>
      <h2>ログイン</h2>
      USER
      <input type="text" value={form.name} onChange={handleChange("name")} />
      <br />
      <br />
      PASSWORD
      <input type="text" value={form.pass} onChange={handleChange("pass")} />
      <br />
      <br />
      <button
        onClick={() =>
          navigate("/auth", {
            state: { user: form.name, pass: form.pass },
            replace: true,
          })
        }
      >
        送信
      </button>
    </div>
  );
};
